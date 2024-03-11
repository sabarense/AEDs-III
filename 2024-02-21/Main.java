import java.io.*;

class Main {

  public static void main(String args[]) {

    RandomAccessFile arq;
    Livro l1 = new Livro(1, "Odisséia", "Homero", 15.99F);
    Livro l2 = new Livro(2, "Ensino Híbrido", "Lilian Bacich", 39.90F);
    Livro l3 = new Livro();
    long end1, end2;

    try {
      arq = new RandomAccessFile("dados/livros.db", "rw");
      byte[] ba;

      end1 = arq.getFilePointer();
      ba = l1.toByteArray();
      arq.writeShort((short) ba.length);
      arq.write(ba);

      end2 = arq.getFilePointer();
      ba = l2.toByteArray();
      arq.writeShort((short) ba.length);
      arq.write(ba);

      arq.seek(end2);
      short tam;
      tam = arq.readShort();
      ba = new byte[tam];
      arq.read(ba);
      l3.fromByteArray(ba);
      System.out.println(l3);

      arq.seek(end1);
      tam = arq.readShort();
      ba = new byte[tam];
      arq.read(ba);
      l3.fromByteArray(ba);
      System.out.println(l3);

      arq.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}