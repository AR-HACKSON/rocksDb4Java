import org.rocksdb.RocksDB;

import org.rocksdb.*;

public class Main {

    static {
        RocksDB.loadLibrary();
    }

    public static void main(String[] args) throws  RocksDBException {

        System.out.println("=======start========");
        String path = "/data1/arwave/rocksdb";

        RocksDB rocksDB;

        Options options = new Options();
        options.setCreateIfMissing(true);
        rocksDB = RocksDB.open(options, path);

//        rocksDB.put("hello".getBytes(),"world".getBytes());
//
//        byte[] bytes = rocksDB.get("hello".getBytes());
//        System.out.println(new String(bytes));

        RocksIterator iter = rocksDB.newIterator();
        for (iter.seekToFirst(); iter.isValid(); iter.next()) {
            System.out.println("-------------------");
            System.out.println("iter key:" + new String(iter.key())
                    + ", iter value:" + iter.value().length);
        }

        System.out.println("-------end------------");
    }
}
