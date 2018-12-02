package Backend;

/**
 * The exception generated when trying to create a object that already exists.
 */
public class ProductExistsException extends Exception{
    public ProductExistsException(String message){
        super(message);
    }
}

