package swift;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;

@ThriftService("mathService")
public class MathService {

    @ThriftMethod
    public int sum(final int a, final int b) {
        return a + b;
    }
}
