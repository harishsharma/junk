package nio;

public class BlockIO {

    private final int size;

    BlockIO(int size) {
        this.size = size;
    }

    int bSeek(int blockNum) {
        return 0;
    }

    int bWrite() {
        return 0;
    }

    int blockSize() {
        return this.size;
    }


    class Block {
        private byte[] data;

    }
}
