public class Downloading extends AMDState {
    public Downloading(Context context) {
        super(context);
    }

    @Override
    public void downloadFinish() {
        context.userPoints++;
        if (context.filesInQueue == 0) {
            context.setDownloadCurrentState(context.waitingForDownload);
        } else if (context.isEnoughSpace) {
            context.setDownloadCurrentState(context.downloading);
        } else {
            context.setDownloadCurrentState(context.pauseDownload);
        }

        if (context.userPoints < 4 && !context.userStatus.equals("b")) {
            context.downloadSpeed = 1;
            context.setUserCurrentState(context.beginnerUser);
            context.userStatus = "b";
        } else if (context.userPoints > 4 && context.userPoints < 7 && !context.userStatus.equals("a")) {
            context.downloadSpeed = 1.2;
            context.setUserCurrentState(context.advancedUser);
            context.userStatus = "a";
        } else if (context.userPoints > 7 && !context.userStatus.equals("p")) {
            context.downloadSpeed = 1.5;
            context.setUserCurrentState(context.professionalUser);
            context.userStatus = "p";
        }
    }

    @Override
    public void downloadAborted() {
        if (context.userPoints > 0) {
            context.userPoints--;
        }
        if (context.filesInQueue == 0) {
            context.setDownloadCurrentState(context.waitingForDownload);
        } else if (context.isEnoughSpace) {
            context.setDownloadCurrentState(context.downloading);
        } else {
            context.setDownloadCurrentState(context.pauseDownload);
        }

        if (context.userPoints < 4 && !context.userStatus.equals("b")) {
            context.downloadSpeed = 1;
            context.setUserCurrentState(context.beginnerUser);
        } else if (context.userPoints > 4 && context.userPoints < 7 && !context.userStatus.equals("a")) {
            context.downloadSpeed = 1.2;
            context.setUserCurrentState(context.advancedUser);
        } else if (context.userPoints > 7 && !context.userStatus.equals("p")) {
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
