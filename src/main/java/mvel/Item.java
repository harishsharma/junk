package mvel;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author harish.sharma
 *
 */
@Data
@RequiredArgsConstructor
public class Item {
    private final String  name;
    private final Integer salary;
}
