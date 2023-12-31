// Talha Tahmid 1001910304

package library;
import java.time.Duration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


/*
 * A library video that can be checked out by patron
 * 
 * 
 */
public class Video extends Publication
{
    private Duration runtime;

    /**
     * Constructs a Video object with the given title, author, copyright year, and runtime.
     *
     * @title    The title of the video.
     * @author   The author of the video.
     * @runtime  The runtime of the video in minutes.
     * @license  License of the video
     * @throws   If the runtime is less than or equal to zero.
     */

    public Video(String title, String author, int copyright, int runtime)
    {
        super(title, author, copyright);
        this.runtime = Duration.ofMinutes(runtime);
        if(runtime <= 0)
        {
            throw new InvalidRuntimeException(title, runtime);
        }
    }

    /**
     * Constructs a Video object by reading data from a BufferedReader.
     *
     * @param br The BufferedReader from which to read video data.
     * @throws IOException If an I/O error occurs.
     */

    public Video(BufferedReader br) throws IOException {
        super(br); 
        int runtimeMinutes = Integer.parseInt(br.readLine());
        this.runtime = Duration.ofMinutes(runtimeMinutes);
    }
    /**
     * Saves the video data to a BufferedWriter.
     *
     * @param bw The BufferedWriter to which the video data should be saved.
     * @throws IOException If an I/O error occurs.
     */

    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(runtime.toMinutes() + "\n");
    }

    /**
     * A custom exception class representing an invalid runtime for a video.
     */

    public static class InvalidRuntimeException extends ArithmeticException
    {
        /**
         * Constructs a new InvalidRuntimeException with no detail message.
         */
        public InvalidRuntimeException()
        {
            super();
        }
        public InvalidRuntimeException(String s)
        {
            super(s);
        }


        public InvalidRuntimeException(String title, int runtime)
        {
            super(title + " has invalid runtime " + runtime );
        }
    }


    /**
     * Overrides the toString method to provide a string representation of the Video object.
     *
     * @return A string representation of the Video object.
     */
    
    @Override
    public String toString()
    {
        return toStringBuilder("Video", "runtime " + runtime.toMinutes() + " minutes");
    }
}