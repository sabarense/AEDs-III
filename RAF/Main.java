package RAF;

import java.io.RandomAccessFile;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {

            /* WRITE */

            RandomAccessFile RAF = new RandomAccessFile("RAF/dados/livros.db", "rw");
            byte[] byteArray;

            Livro livro1 = new Livro(1, "Eu, Robô", "Isaac Asimov", 14.9F);
            Livro livro2 = new Livro(2, "Eu sou A Lenda", "Richard Matheson", 21.99F);

            // livro1
            long pointer1 = RAF.getFilePointer();
            byteArray = livro1.toByteArray();
            RAF.writeInt(byteArray.length);
            RAF.write(byteArray);

            // livro2
            long pointer2 = RAF.getFilePointer();
            byteArray = livro2.toByteArray();
            RAF.writeInt(byteArray.length);
            RAF.write(byteArray);

            /* READ */
            Livro livro3 = new Livro();
            Livro livro4 = new Livro();
            int tam;

            // livro3
            RAF.seek(pointer1);
            tam = RAF.readInt();
            byteArray = new byte[tam];
            RAF.readFully(byteArray);
            livro3.fromByteArray(byteArray);
            System.out.println(livro3);

            // livro4
            RAF.seek(pointer2);
            tam = RAF.readInt();
            byteArray = new byte[tam];
            RAF.readFully(byteArray);
            livro4.fromByteArray(byteArray);
            System.out.println(livro4);

            RAF.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}