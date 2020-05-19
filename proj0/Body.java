public class Body {
  // current position
  public double xxPos;
  public double yyPos;
  // current velocity
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  public Body(double xP, double yP, double xV, double yV,
  double m, String img){
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  public Body(Body b) {
    xxPos =  b.xxPos;
    yyPos = b.yyPos;
    xxVel = b.xxVel;
    yyVel = b.yyVel;
    mass = b.mass;
    imgFileName = b.imgFileName;
  }

  public double calcDistance(Body b) {
    double dxx = b.xxPos - this.xxPos;
    double dyy = b.yyPos - this.yyPos;
    double r2 = dxx * dxx + dyy * dyy;
    double r = Math.sqrt(r2);
    return r;
  }

  public double calcForceExertedBy(Body b) {
    double G = 6.67 * Math.pow(10, -11);
    double force = G * this.mass * b.mass / Math.pow(this.calcDistance(b), 2);
    return force;
  }

  public double calcForceExertedByX(Body b) {
    double dxx = b.xxPos - this.xxPos;
    double forceX = this.calcForceExertedBy(b) * dxx /  this.calcDistance(b);
    return forceX;
  }

  public double calcForceExertedByY(Body b) {
    double dyy = b.yyPos - this.yyPos;
    double forceY = this.calcForceExertedBy(b) * dyy /  this.calcDistance(b);
    return forceY;
  }

  public double calcNetForceExertedByX(Body[] b) {
    double netForceX = 0;
    int i = 0;
    while (i<b.length) {
      if (this.equals(b[i])) {
        i=i+1;
        continue;
      }
      netForceX = netForceX + this.calcForceExertedByX(b[i]);
      i = i+1;
    }
    return netForceX;
  }

  public double calcNetForceExertedByY(Body[] b) {
    double netForceY = 0;
    int i = 0;
    while (i<b.length) {
      if (this.equals(b[i])) {
        i=i+1;
        continue;
      }
      netForceY = netForceY + this.calcForceExertedByY(b[i]);
      i = i+1;
    }
    return netForceY;
  }

  public void update(double dt, double xforce, double yforce) {
    double accelerationX = xforce/this.mass;
    double accelerationY = yforce/this.mass;
    this.xxVel = this.xxVel + dt * accelerationX;
    this.yyVel = this.yyVel + dt * accelerationY;
    this.xxPos = this.xxPos + dt * this.xxVel;
    this.yyPos = this.yyPos + dt * this.yyVel;
  }

  public void draw() {
    StdDraw.picture(xxPos, yyPos, "./images/"+imgFileName);
  }
}
