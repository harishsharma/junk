package reflection;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
class RefTest {
    private int a = 1;

    RefTest(int a) {
        this.a = a;
    }

    void someMethod() {
        log.debug("a is {}", a);
    }

}
