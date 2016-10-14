package storage.test;
import storage.Storage;



/**
 * Created by Sveta on 14.10.2016.
 */
public class ListStorageTest extends AbstractArrayStorageTest{

   public ListStorageTest (Storage storage){
       super(new ListStorage());
   }
}