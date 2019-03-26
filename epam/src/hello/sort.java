package hello;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
 
public class sort {
   
    static int numChar;
    static int curChar;
    static byte[] buffer = new byte[1024];
    static InputStream stream;
    static PrintWriter out;
 
    public static void main(String[] args) throws IOException {
 
        stream = System.in;
        out = new PrintWriter(System.out);
 
        int n =  readInt();
        int k = readInt();
        int a[] = new int[n];
        List<Integer> b[] = new List[k];
        int j = 0;
        for (int i = 0; i < n; i++) {
            a[i] = readInt();
            j = a[i] % k;
            if (b[j] == null)
                b[j] = new ArrayList<Integer>();
            b[j].add(a[i]);
        }
 
        for (int i = k-1; i >= 0; i--)
            if (b[i] != null) {
                Collections.sort(b[i]);
                for (int l = 0; l < b[i].size(); l++)
                    out.print(b[i].get(l) + " ");
            }
        out.flush();
        out.close();
    }
 
    public static int read() throws IOException {
        if (numChar <= curChar) {
            curChar = 0;
            numChar = stream.read(buffer);
            if (numChar <= 0) {
                return -1;
            }
        }
        return buffer[curChar++];
    }
 
    public static long readLong() throws IOException, InputMismatchException {
        int c = read();
        if (c == -1)
            throw new IOException();
        while (isSpaceChar(c)) {
            c = read();
        }
        boolean negative = false;
        if (c == '-') {
            negative = true;
            c = read();
        }
        long res = 0;
        while (!isSpaceChar(c)) {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += (c - '0');
            c = read();
        }
        if (negative)
            return -res;
        return res;
    }
 
 
 
    public static int readInt() throws IOException, InputMismatchException {
        return (int) readLong();
    }
 
    public static String readString() throws IOException {
        int c = read();
        if (c == -1)
            throw new IOException();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder builder = new StringBuilder();
        while (!isSpaceChar(c)) {
            builder.append((char) c);
            c = read();
        }
        return builder.toString();
    }
 
    public static boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\t' || c == '\r' || c == -1;
    }
 
}
