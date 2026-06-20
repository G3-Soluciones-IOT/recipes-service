package pe.edu.upc.recipes_service.recipes.application.internal.outboundedservices;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;
import pe.edu.upc.recipes_service.recipes.domain.model.valueobjects.MacronutrientValuesId;
import pe.edu.upc.recipes_service.recipes.domain.model.valueobjects.UserId;

import java.util.Optional;

@Service
public class ExternalProfileAndTrackingService {

    private static final String INTERNAL_HEADER = "X-Internal-Request";

    private final RestClient profilesClient;
    private final RestClient nutritionistsClient;
    private final RestClient trackingClient;
    private final String internalSecret;

    public ExternalProfileAndTrackingService(
            @Qualifier("loadBalancedRestClientBuilder") RestClient.Builder restClientBuilder,
            @Value("${clients.profiles.base-url}") String profilesBaseUrl,
            @Value("${clients.nutritionists.base-url}") String nutritionistsBaseUrl,
            @Value("${clients.tracking.base-url}") String trackingBaseUrl,
            @Value("${authorization.internal-service.secret}") String internalSecret) {
        this.profilesClient = restClientBuilder.baseUrl(profilesBaseUrl).build();
        this.nutritionistsClient = restClientBuilder.baseUrl(nutritionistsBaseUrl).build();
        this.trackingClient = restClientBuilder.baseUrl(trackingBaseUrl).build();
        this.internalSecret = internalSecret;
    }

    public String getNutritionistNameOrDefault(Long userId) {
        return getNutritionist(userId)
                .map(NutritionistResource::fullName)
                .filter(name -> !name.isBlank())
                .orElse("Unknown author (ID: " + userId + ")");
    }

    public void validateUserProfile(UserId userId) {
        if (!existsProfileById(userId.userId())) {
            throw new IllegalArgumentException(
                    "No regular user profile found with ID: " + userId.userId()
            );
        }
    }

    public void validateNutritionist(UserId userId) {
        if (getNutritionist(userId.userId()).isEmpty()) {
            throw new IllegalArgumentException(
                    "No nutritionist found with userId: " + userId.userId()
            );
        }
    }

    public Optional<String> getObjectiveNameByUserId(UserId userId) {
        if (!existsProfileById(userId.userId())) {
            return Optional.empty();
        }

        try {
            var resource = profilesClient.get()
                    .uri("/api/v1/profiles/{profileId}/objective", userId.userId())
                    .header(INTERNAL_HEADER, internalSecret)
                    .retrieve()
                    .body(ObjectiveResource.class);
            return Optional.ofNullable(resource).map(ObjectiveResource::objectiveName);
        } catch (RestClientException exception) {
            return Optional.empty();
        }
    }

    public String getValidatedObjectiveName(UserId userId) {
        return getObjectiveNameByUserId(userId)
                .orElse("No objective defined (nutritionist or user with no objective)");
    }

    public void validateMacronutrientValuesExists(MacronutrientValuesId macronutrientValuesId) {
        if (!existsMacronutrientValues(macronutrientValuesId.macronutrientValuesId())) {
            throw new IllegalArgumentException(
                    "MacronutrientValues not found with ID: " + macronutrientValuesId.macronutrientValuesId());
        }
    }

    private boolean existsProfileById(Long profileId) {
        try {
            var resource = profilesClient.get()
                    .uri("/api/v1/profiles/{profileId}/exists", profileId)
                    .header(INTERNAL_HEADER, internalSecret)
                    .retrieve()
                    .body(ExistsResource.class);
            return resource != null && resource.exists();
        } catch (RestClientException exception) {
            return false;
        }
    }

    private Optional<NutritionistResource> getNutritionist(Long userId) {
        try {
            return Optional.ofNullable(nutritionistsClient.get()
                    .uri("/api/v1/nutritionists/users/{userId}", userId)
                    .header(INTERNAL_HEADER, internalSecret)
                    .retrieve()
                    .body(NutritionistResource.class));
        } catch (RestClientException exception) {
            return Optional.empty();
        }
    }

    private boolean existsMacronutrientValues(Long macronutrientValuesId) {
        try {
            var resource = trackingClient.get()
                    .uri("/api/v1/macronutrient-values/{macronutrientValuesId}/exists", macronutrientValuesId)
                    .header(INTERNAL_HEADER, internalSecret)
                    .retrieve()
                    .body(ExistsResource.class);
            return resource != null && resource.exists();
        } catch (RestClientException exception) {
            return false;
        }
    }

    private record ExistsResource(boolean exists) {
    }

    private record ObjectiveResource(String objectiveName) {
    }

    private record NutritionistResource(Long userId, String fullName) {
    }
}
