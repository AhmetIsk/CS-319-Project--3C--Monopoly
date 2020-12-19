package FileControllerManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInfoReader implements Serializable
{

    //methods

    public static String[] getPropertiesNames(String fileName)
    {
        int NUMBER;
        if ( fileName == "PlanetNamesUpdate") {
            NUMBER = 22;
        }
        else
            NUMBER = 4;

        try
        {
            String[] planets;
            FileReader fr;
            BufferedReader br;

            planets = new String[ NUMBER ];
            fr = new FileReader( "src/Game Files/" + fileName + ".txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < NUMBER; i++ )
            {
                planets[ i ] = br.readLine();
            }

            return planets;
        }
        catch (IOException e)
        {

            return null;

        }
    }

    //
    public static Integer[] getPropertiesPositions(String fileName)
    {
        int NUMBER;
        if ( fileName == "PlanetsPositions") {
            NUMBER = 22;
        }
        else
            NUMBER = 4;

        try
        {
            Integer[] positions;
            FileReader fr;
            BufferedReader br;

            positions = new Integer[ NUMBER ];
            fr = new FileReader( "src/Game Files/" + fileName + ".txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < NUMBER; i++ )
            {
                positions[ i ] = Integer.parseInt(br.readLine());
            }

            return positions;
        }
        catch (IOException e)
        {
            return null;
        }
    }

    //
    public static Integer[] getPropertiesPrice(String fileName)
    {
        int NUMBER;
        if ( fileName == "PlanetsPrices") {
            NUMBER = 22;
        }
        else
            NUMBER = 4;

        try
        {
            Integer[] prices;
            FileReader fr;
            BufferedReader br;

            prices = new Integer[ NUMBER ];
            fr = new FileReader( "src/Game Files/" + fileName + ".txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < NUMBER; i++ )
            {
                prices[ i ] = Integer.parseInt(br.readLine());
            }

            return prices;
        }
        catch (IOException e)
        {
            return null;
        }
    }

    //
    public static Integer[] getPlanetsMortgagePrice()
    {
        final int PLANET_NUMBER = 22;

        try
        {
            Integer[] prices;
            FileReader fr;
            BufferedReader br;

            prices = new Integer[ PLANET_NUMBER ];
            fr = new FileReader( "src/Game Files/PlanetsMortgagePrices.txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < PLANET_NUMBER; i++ )
            {
                prices[ i ] = Integer.parseInt(br.readLine());
            }

            return prices;
        }
        catch (IOException e)
        {
            return null;
        }
    }

    //
    public static Integer[] getPropertiesRentPrice( String fileName)
    {
        int NUMBER;
        if ( fileName == "PlanetsRentPrices") {
            NUMBER = 22;
        }
        else
            NUMBER = 4;

        try
        {
            Integer[] prices;
            FileReader fr;
            BufferedReader br;

            prices = new Integer[ NUMBER ];
            fr = new FileReader( "src/Game Files/" + fileName + ".txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < NUMBER; i++ )
            {
                prices[ i ] = Integer.parseInt(br.readLine());
            }

            return prices;
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public static ArrayList<String> getMusics()
    {
        final int MUSIC_NUMBER = 2;

        try
        {
            ArrayList<String> musics;
            FileReader fr;
            BufferedReader br;

            musics = new ArrayList<String>();
            fr = new FileReader( "src/Game Files/Musics.txt" );
            br = new BufferedReader( fr );
            for ( int i = 0; i < MUSIC_NUMBER; i++ )
            {
                musics.add( br.readLine() );
            }

            return musics;
        }
        catch (IOException e)
        {
            return null;
        }
    }
}
