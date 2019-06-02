public class PauseDownload extends AMDState {
    public PauseDownload(Context context) {
        super(context);
    }

    @Override
    public void enterState() {
        super.enterState();
        context.time = 0;
    }

    @Override
    public void downloadDelete() {
        if (context.time > 4) {
            if (!context.isEnoughSpace)
                context.setDownloadCurrentState(context.waitingForDownload);
            else if (context.isInternetConnected) {
                context.setDownloadCurrentState(context.downloading);
            }
        }
    }
}
