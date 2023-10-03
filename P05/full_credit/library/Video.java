package library;
import java.time.Duration;


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