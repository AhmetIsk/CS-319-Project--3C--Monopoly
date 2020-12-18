package FileControllerManager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

public class CSVReader extends BufferedReader implements Serializable
{
    // properties
    public static final char QUOTER = '"';
    boolean write;

    // constructors
    public CSVReader( FileReader fr )
    {
        super( fr );
        write = false;
    }

    // methods

    /**
     * reads the information inside the CSV file
     * @return the string that is inside two QUOTER (") character. ( That is: "reads this whole part" )
     */
    public String next() throws IOException
    {
        String s;
        char c;

        while ( !write )
        {
            c = (char)super.read();
            if ( c == QUOTER )
            {
                write = true;
            }
        }

        s = "";
        while ( write )
        {
            c = (char)super.read();
            if ( c != QUOTER )
            {
                s = s + c;
            }
            else
            {
                write = false;
            }
        }

        return s;
    }

    //closing the reader
    @Override
    public void close() throws IOException
    {
        super.close();
    }
}

