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
public class Server {
    private final String id;
    private final String ip;
    private final int    port;
}
