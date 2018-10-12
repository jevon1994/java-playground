package exercise.Concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipedTest {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();

        out.connect(in);
        new WriteThread(out).start();
        new ReaderThread(in).start();
    }
}

class WriteThread extends Thread{
    private PipedWriter out;

    public WriteThread(PipedWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        try {
            out.write("写入");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread{
    private PipedReader in;

    public ReaderThread(PipedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            System.out.println(in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}