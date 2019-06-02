public class PausedMovie extends AMDState {
    public PausedMovie(Context context) {
        super(context);
    }

    @Override
    public void resume() {
        if (context.isMoviePausedbyUser){
            context.isMoviePausedbyUser = false;
            context.setMovieCurrentState(context.playingMovie);
        }
        context.setMovieCurrentState(context.playingMovie);
    }

    @Override
    public void errorFixed() {
        if (!context.isMoviePausedbyUser){
            context.setMovieCurrentState(context.playingMovie);
        }
    }

    @Override
    public void internetOn() {
        if (!context.isMoviePausedbyUser){
            context.setMovieCurrentState(context.playingMovie);
        }
    }

    @Override
    public void downloadAborted() {
        context.isMoviePausedbyUser = false;
        context.setMovieCurrentState(context.waitingToPlay);
    }

    @Override
    public void downloadFinish() {
        context.isMoviePausedbyUser = false;
        context.setMovieCurrentState(context.waitingToPlay);
    }
}
