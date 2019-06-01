public class FixingDownload extends AMDState {
    public FixingDownload(Context context) {
        super(context);
    }

    @Override
    public void enterState() {
        super.enterState();
        context.seconds = 0;
    }

    @Override
    public void downloadDelete() {
        context.isEnoughSpace = true;
        if (context.filesInQueue == 0)
            context.setDownloadCurrentState(context.waitingForDownload);
        else
            context.setDownloadCurrentState(context.downloading);
    }

    @Override
    public void downloadFixed() {
        context.setDownloadCurrentState(context.downloading);
    }
}
