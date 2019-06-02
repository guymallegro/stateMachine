public class PlayingMovie extends AMDState {


    public PlayingMovie(Context context) {
        super(context);
    }

    @Override
    public void restartMovie() {
        context.stoppedAtFrame = 0;
    }

    @Override
    public void downloadFinish() {
        context.setMovieCurrentState(context.waitingToPlay);
    }

    @Override
    public void downloadAborted() {
        context.setMovieCurrentState(context.waitingToPlay);
    }

    @Override
    public void movieOff() {
        context.setMovieCurrentState(context.waitingToPlay);
    }

    @Override
    public void holdMovie() {
        context.isMoviePaused = true;
        context.setMovieCurrentState(context.pausedMovie);
    }

    @Override
    public void downloadError() {
        context.setMovieCurrentState(context.pausedMovie);
    }

    @Override
    public void internetOff() {
        context.setMovieCurrentState(context.pausedMovie);
    }


}
