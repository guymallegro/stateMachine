public class WaitingToPlay extends AMDState {
    public WaitingToPlay(Context context) {
        super(context);
    }

    @Override
    public void movieOn() {
        if (context.downloadPercentage > 20) {
            context.setMovieCurrentState(context.playingMovie);
        }
    }
}
