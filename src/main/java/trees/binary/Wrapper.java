package trees.binary;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Wrapper<T> {
    T value;
}
