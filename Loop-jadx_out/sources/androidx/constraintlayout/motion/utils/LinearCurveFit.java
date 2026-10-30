package androidx.constraintlayout.motion.utils;

/* JADX INFO: loaded from: classes17.dex */
public class LinearCurveFit extends CurveFit {
    private static final String TAG = "LinearCurveFit";

    /* JADX INFO: renamed from: mT */
    private double[] f182mT;
    private double mTotalLength;

    /* JADX INFO: renamed from: mY */
    private double[][] f183mY;

    public LinearCurveFit(double[] time, double[][] y) {
        this.mTotalLength = Double.NaN;
        int length = time.length;
        char c = 0;
        int dim = y[0].length;
        this.f182mT = time;
        this.f183mY = y;
        if (dim > 2) {
            double sum = 0.0d;
            double lastx = 0.0d;
            double lasty = 0.0d;
            int i = 0;
            while (i < time.length) {
                double px = y[i][c];
                double py = y[i][c];
                if (i > 0) {
                    sum += Math.hypot(px - lastx, py - lasty);
                }
                lastx = px;
                lasty = py;
                i++;
                dim = dim;
                c = 0;
            }
            this.mTotalLength = 0.0d;
        }
    }

    private double getLength2D(double t) {
        LinearCurveFit linearCurveFit = this;
        if (Double.isNaN(linearCurveFit.mTotalLength)) {
            return 0.0d;
        }
        int n = linearCurveFit.f182mT.length;
        if (t <= linearCurveFit.f182mT[0]) {
            return 0.0d;
        }
        if (t >= linearCurveFit.f182mT[n - 1]) {
            return linearCurveFit.mTotalLength;
        }
        double sum = 0.0d;
        double last_x = 0.0d;
        double last_y = 0.0d;
        int i = 0;
        while (i < n - 1) {
            double px = linearCurveFit.f183mY[i][0];
            double py = linearCurveFit.f183mY[i][1];
            if (i > 0) {
                double d = px - last_x;
                double last_x2 = py - last_y;
                sum += Math.hypot(d, last_x2);
            }
            last_x = px;
            last_y = py;
            if (t == linearCurveFit.f182mT[i]) {
                return sum;
            }
            if (t >= linearCurveFit.f182mT[i + 1]) {
                i++;
                linearCurveFit = this;
            } else {
                double h = linearCurveFit.f182mT[i + 1] - linearCurveFit.f182mT[i];
                double x = (t - linearCurveFit.f182mT[i]) / h;
                double x1 = linearCurveFit.f183mY[i][0];
                double x2 = linearCurveFit.f183mY[i + 1][0];
                double y1 = linearCurveFit.f183mY[i][1];
                double y2 = linearCurveFit.f183mY[i + 1][1];
                return sum + Math.hypot(py - (((1.0d - x) * y1) + (y2 * x)), px - (((1.0d - x) * x1) + (x2 * x)));
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double t, double[] v) {
        int n = this.f182mT.length;
        int dim = this.f183mY[0].length;
        if (t <= this.f182mT[0]) {
            for (int j = 0; j < dim; j++) {
                v[j] = this.f183mY[0][j];
            }
            return;
        }
        if (t >= this.f182mT[n - 1]) {
            for (int j2 = 0; j2 < dim; j2++) {
                v[j2] = this.f183mY[n - 1][j2];
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (t == this.f182mT[i]) {
                for (int j3 = 0; j3 < dim; j3++) {
                    v[j3] = this.f183mY[i][j3];
                }
            }
            if (t < this.f182mT[i + 1]) {
                double h = this.f182mT[i + 1] - this.f182mT[i];
                double x = (t - this.f182mT[i]) / h;
                for (int j4 = 0; j4 < dim; j4++) {
                    double y1 = this.f183mY[i][j4];
                    double y2 = this.f183mY[i + 1][j4];
                    v[j4] = ((1.0d - x) * y1) + (y2 * x);
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getPos(double t, float[] v) {
        int n = this.f182mT.length;
        int dim = this.f183mY[0].length;
        if (t <= this.f182mT[0]) {
            for (int j = 0; j < dim; j++) {
                v[j] = (float) this.f183mY[0][j];
            }
            return;
        }
        if (t >= this.f182mT[n - 1]) {
            for (int j2 = 0; j2 < dim; j2++) {
                v[j2] = (float) this.f183mY[n - 1][j2];
            }
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            if (t == this.f182mT[i]) {
                for (int j3 = 0; j3 < dim; j3++) {
                    v[j3] = (float) this.f183mY[i][j3];
                }
            }
            if (t < this.f182mT[i + 1]) {
                double h = this.f182mT[i + 1] - this.f182mT[i];
                double x = (t - this.f182mT[i]) / h;
                for (int j4 = 0; j4 < dim; j4++) {
                    double y1 = this.f183mY[i][j4];
                    double y2 = this.f183mY[i + 1][j4];
                    v[j4] = (float) (((1.0d - x) * y1) + (y2 * x));
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getPos(double t, int j) {
        int n = this.f182mT.length;
        if (t <= this.f182mT[0]) {
            return this.f183mY[0][j];
        }
        if (t >= this.f182mT[n - 1]) {
            return this.f183mY[n - 1][j];
        }
        for (int i = 0; i < n - 1; i++) {
            if (t == this.f182mT[i]) {
                return this.f183mY[i][j];
            }
            if (t < this.f182mT[i + 1]) {
                double h = this.f182mT[i + 1] - this.f182mT[i];
                double x = (t - this.f182mT[i]) / h;
                double y1 = this.f183mY[i][j];
                double y2 = this.f183mY[i + 1][j];
                return ((1.0d - x) * y1) + (y2 * x);
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public void getSlope(double t, double[] v) {
        double t2;
        int n = this.f182mT.length;
        int dim = this.f183mY[0].length;
        if (t <= this.f182mT[0]) {
            t2 = this.f182mT[0];
        } else if (t < this.f182mT[n - 1]) {
            t2 = t;
        } else {
            t2 = this.f182mT[n - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            if (t2 <= this.f182mT[i + 1]) {
                double h = this.f182mT[i + 1] - this.f182mT[i];
                double d = (t2 - this.f182mT[i]) / h;
                for (int j = 0; j < dim; j++) {
                    double y1 = this.f183mY[i][j];
                    double y2 = this.f183mY[i + 1][j];
                    v[j] = (y2 - y1) / h;
                }
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double getSlope(double t, int j) {
        double t2;
        int n = this.f182mT.length;
        if (t < this.f182mT[0]) {
            t2 = this.f182mT[0];
        } else if (t < this.f182mT[n - 1]) {
            t2 = t;
        } else {
            t2 = this.f182mT[n - 1];
        }
        for (int i = 0; i < n - 1; i++) {
            if (t2 <= this.f182mT[i + 1]) {
                double h = this.f182mT[i + 1] - this.f182mT[i];
                double d = (t2 - this.f182mT[i]) / h;
                double y1 = this.f183mY[i][j];
                double y2 = this.f183mY[i + 1][j];
                return (y2 - y1) / h;
            }
        }
        return 0.0d;
    }

    @Override // androidx.constraintlayout.motion.utils.CurveFit
    public double[] getTimePoints() {
        return this.f182mT;
    }
}
