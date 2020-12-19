package FileControllerManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GameInfoReader implements Serializable
{

    //methods

    public static String[] getPlanetNames()
    {
        final int PLANET_NUMBER = 22;

        try
        {
            String[] planets;
            FileReader fr;
            BufferedReader br;

            planets = new String[ PLANET_NUMBER ];
            fr = new FileReader( "src/Game Files/PlanetNamesUpdate.txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < PLANET_NUMBER; i++ )
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
    public static Integer[] getPlanetSPositions()
    {
        final int PLANET_NUMBER = 22;

        try
        {
            Integer[] positions;
            FileReader fr;
            BufferedReader br;

            positions = new Integer[ PLANET_NUMBER ];
            fr = new FileReader( "src/Game Files/PlanetsPositions.txt" );
            br = new BufferedReader( fr );
            for( int i = 0; i < PLANET_NUMBER; i++ )
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
    public static Integer[] getPlanetsPrice()
    {
        final int PLANET_NUMBER = 22;

        try
        {
            Integer[] prices;
            FileReader fr;
            BufferedReader br;

            prices = new Integer[ PLANET_NUMBER ];
            fr = new FileReader( "src/Game Files/PlanetsPrices.txt" );
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
    public static Integer[] getPlanetsRentPrice()
    {
        final int PLANET_NUMBER = 22;

        try
        {
            Integer[] prices;
            FileReader fr;
            BufferedReader br;

            prices = new Integer[ PLANET_NUMBER ];
            fr = new FileReader( "src/Game Files/PlanetsRentPrices.txt" );
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
