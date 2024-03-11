import java.io.RandomAccessFile;

public class Arquivo {

  RandomAccessFile arq;
  String nomeArquivo = "";

  public Arquivo(String na) throws Exception {
    this.nomeArquivo = na;
    arq = new RandomAccessFile(na, "rw");
    if (arq.length() < 4) {
      arq.seek(0);
      arq.writeInt(0);
    }
  }

  public int create(Livro obj) throws Exception {
    arq.seek(0);
    int ultimoID = arq.readInt();
    ultimoID++;
    arq.seek(0);
    arq.writeInt(ultimoID);
    obj.setID(ultimoID);

    arq.seek(arq.length());
    long endereco = arq.getFilePointer();
    byte[] ba = obj.toByteArray();
    short tam = (short) ba.length;
    arq.write(' '); // lápide
    arq.writeShort(tam);
    arq.write(ba);

    return obj.getID();
  }

  public Livro read(int id) {
    Livro l = new Livro();

    // código para busca sequencial do livro

    return l;
  }

  public void close() throws Exception {
    arq.close();
  }
}
