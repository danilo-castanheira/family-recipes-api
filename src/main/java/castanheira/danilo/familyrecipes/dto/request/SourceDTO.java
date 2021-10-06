package castanheira.danilo.familyrecipes.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SourceDTO {
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 200)
    private String name;
}
