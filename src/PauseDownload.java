public class PauseDownload extends AMDState {
    public PauseDownload(Context context) {
        super(context);
    }

    @Override
    public void downloadDelete() {
        if (context.seconds > 4) {
            if (!context.isEnoughSpace)
                context.setDownloadCurrentState(context.waitingForDownload);
            else {
                context.setDownloadCurrentState(context.downloading);
            }
        }
    }
}
