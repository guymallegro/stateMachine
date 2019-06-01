public class PausedMovie extends AMDState {
    public PausedMovie(Context context) {
        super(context);
    }

    @Override
    public void resume() {
        context.setMovieCurrentState(context.playingMovie);
    }

    @Override
    public void errorFixed() {
        context.setMovieCurrentState(context.playingMovie);
    }

    @Override
    public void internetOn() {
        context.setMovieCurrentState(context.playingMovie);
    }

    @Override
    public void downloadAborted() {
        context.setMovieCurrentState(context.waitingToPlay);
    }

    @Override
    public void downloadFinish() {
        context.setMovieCurrentState(context.waitingToPlay);
    }
}
