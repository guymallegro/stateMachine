public class Downloading extends AMDState {
    public Downloading(Context context) {
        super(context);
    }

    @Override
    public void downloadFinish() {
        if (context.filesInQueue == 0) {
            context.userPoints++;
            context.setDownloadCurrentState(context.waitingForDownload);
        } else if (context.isEnoughSpace) {
            context.userPoints++;
            context.setDownloadCurrentState(context.downloading);
        } else {
            context.userPoints++;
            context.setDownloadCurrentState(context.pauseDownload);
        }

        if (context.userPoints < 4) {
            context.downloadSpeed = 1;
            context.setUserCurrentState(context.beginnerUser);
        } else if (context.userPoints < 7) {
            context.downloadSpeed = 1.2;
            context.setUserCurrentState(context.advancedUser);
        } else {
            context.downloadSpeed = 1.5;
            context.setUserCurrentState(context.professionalUser);
        }
    }

    @Override
    public void downloadAborted() {
        if (context.filesInQueue == 0) {
            context.userPoints--;
            context.setDownloadCurrentState(context.waitingForDownload);
        } else if (context.isEnoughSpace) {
            context.userPoints--;
            context.setDownloadCurrentState(context.downloading);
        } else {
            context.userPoints--;
            context.setDownloadCurrentState(context.pauseDownload);
        }

        if (context.userPoints < 4) {
            context.downloadSpeed = 1;
            context.setUserCurrentState(context.beginnerUser);
        } else if (context.userPoints < 7) {
            context.downloadSpeed = 1.2;
            context.setUserCurrentState(context.advancedUser);
        } else {
            context.downloadSpeed = 1.5;
            context.setUserCurrentState(context.professionalUser);
        }
    }

    @Override
    public void downloadError() {
        context.setDownloadCurrentState(context.fixingDownload);
    }

    @Override
    public void internetOff() {
        context.setDownloadCurrentState(context.waitingForInternet);
    }

    @Override
    public void fileRequest() {
        context.filesInQueue++;
    }
}
