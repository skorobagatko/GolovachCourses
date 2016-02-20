package module4_io.my_array_output_stream;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArrayOutputStream extends OutputStream {
    private static final int DEFAULT_SIZE = 16;
    private static final AllocateStrategy DEFAULT_STRATEGY = new DoubleAllocateStrategy();
    private final AllocateStrategy strategy;
    private List<byte[]> bufferList = new ArrayList<>();
    private int count = 0;

    public ArrayOutputStream() {
        this(DEFAULT_SIZE, DEFAULT_STRATEGY);
    }

    public ArrayOutputStream(int startSize) {
        this(startSize, DEFAULT_STRATEGY);
    }

    public ArrayOutputStream(AllocateStrategy strategy) {
        this(DEFAULT_SIZE, strategy);
    }

    public ArrayOutputStream(int startSize, AllocateStrategy strategy) {
        bufferList.add(new byte[startSize]);
        this.strategy = strategy;
    }

    public void write(int b) throws IOException {
        byte[] lastBuff = bufferList.get(bufferList.size() - 1);
        if (count == lastBuff.length) {
            int newSize = strategy.nextAfter(lastBuff.length);
            byte[] newLastBuffer = new byte[newSize];
            bufferList.add(newLastBuffer);
            count = 0;
            lastBuff = newLastBuffer;
        }
        lastBuff[count++] = (byte) b;
    }

    @Override
    public void write(byte[] b) throws IOException {
        if (b == null) { throw new IllegalArgumentException(); }
        byte[] lastBuff = bufferList.get(bufferList.size()-1);
        int newSize = strategy.nextAfter(lastBuff.length);
        if (count == lastBuff.length) {
            while (b.length > newSize) { newSize = strategy.nextAfter(newSize); }
            byte[] newLastBuffer = new byte[newSize];
            bufferList.add(newLastBuffer);
            System.arraycopy(b, 0, newLastBuffer, 0, b.length);
            count = b.length;
        } else {
            int emptySpaceInLastBuffer = lastBuff.length - count;
            int countOfCopiedBytes = 0;
            // Если длина переданного массива меньше количества пустых ячеек в последнем буфере
            // копируем весь переданный массив в последний буффер
            if (emptySpaceInLastBuffer > b.length) {
                for(int i = 0; i < b.length; i++) {
                    lastBuff[count++] = b[i];
                }
            // Иначе, копируем в последний буфер все эелементы переданного массива, которые
            // могут поместиться, а остальное копируем в новый буффер
            } else {
                for (int i = 0; i < emptySpaceInLastBuffer; i++) {
                    lastBuff[count] = b[i];
                    countOfCopiedBytes++;
                    count++;
                }
                count = 0;
                int stayedBytesInArray = b.length - countOfCopiedBytes;
                while (stayedBytesInArray > newSize) { newSize = strategy.nextAfter(newSize); }
                byte[] newLastBuffer = new byte[newSize];
                bufferList.add(newLastBuffer);
                System.arraycopy(b, countOfCopiedBytes+1, newLastBuffer, 0, b.length);
                count = stayedBytesInArray;
            }
        }
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (b == null) throw new IllegalArgumentException();
        byte[] lastBuff = bufferList.get(bufferList.size()-1);
        int emptySpaceInLastBuffer = lastBuff.length - count;
        if (emptySpaceInLastBuffer > len) {
//            for (int i = 0; i < len; i++) {
//                lastBuff[count++] = b[off+i];
//            }
            System.arraycopy(b, off, lastBuff, count, len);
            count += len;
        } else {
            int countOfCopiedBytes = 0;
            for (int i = 0; i < emptySpaceInLastBuffer; i++) {
                lastBuff[count++] = b[off+i];
                countOfCopiedBytes++;
            }
            count = 0;
            int stayedBytesInArray = len - countOfCopiedBytes;
            int newSize = strategy.nextAfter(lastBuff.length);
            while ((len - countOfCopiedBytes) > newSize) { newSize = strategy.nextAfter(newSize); }
            byte[] newLastBuffer = new byte[newSize];
            bufferList.add(newLastBuffer);
            for (int i = 0; i < stayedBytesInArray; i++) {
                newLastBuffer[count++] = b[off + countOfCopiedBytes];
            }
        }
    }

    public void writeTo(OutputStream os) throws IOException {
        os.write(this.toByteArray());
    }

    public byte[] toByteArray() {
        int totalLength = 0;
        for (int i = 0; i < bufferList.size()-1; i++) {
            totalLength += bufferList.get(i).length;
        }
        totalLength += count;
        byte[] result = new byte[totalLength];
        int countOfCopiedBytes = 0;
        for (int bufferListIndex = 0; bufferListIndex < bufferList.size()-1; bufferListIndex++) {
            byte[] currentArray = bufferList.get(bufferListIndex);
            for (int arrayIndex = 0; arrayIndex < currentArray.length; arrayIndex++) {
                result[countOfCopiedBytes++] = currentArray[arrayIndex];
            }
        }
        byte[] lastBuffer = bufferList.get(bufferList.size()-1);
        for (int index = 0; index < count; index++) {
            result[countOfCopiedBytes++] = lastBuffer[index];
        }
        return result;
    }
}
