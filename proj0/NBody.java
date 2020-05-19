public class NBody {
  public static double readRadius(String filesource){
    In readRadius = new In(filesource);
    int planetsN = readRadius.readInt();
    double radius = readRadius.readDouble();
    return radius;
  }

  public static Body[] readBodies(String filesource) {
    In readB = new In(filesource);
    int planetsN = readB.readInt();
    Body[] bodies = new Body[planetsN];
    double radius = readB.readDouble();
    int i = 0;
    while (i < planetsN) {
      double xP = readB.readDouble();
      double yP = readB.readDouble();
      double xV = readB.readDouble();
      double yV = readB.readDouble();
      double m = readB.readDouble();
      String img = readB.readString();
      bodies[i] = new Body(xP, yP, xV, yV, m, img);
       i = i+1;
    }
    return bodies;
  }

  public static void main(String[] args){
    double T =Double.parseDouble(args[0]);
    double dt =Double.parseDouble(args[1]);
    String filename = args[2];
    double radius = readRadius(filename);
    Body[] bodies = readBodies(filename);
    StdDraw.enableDoubleBuffering();
    StdDraw.setScale(-radius, radius);
    StdDraw.clear();
    double t = 0;
    while (t <= T) {
      double[] xForces = new double[bodies.length];
      double[] yForces = new double[bodies.length];
      for (int i = 0; i < bodies.length; i = i+1){
        xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
        yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
        bodies[i].update(dt, xForces[i], yForces[i]);
      }
      StdDraw.picture(0, 0, "./images/starfield.jpg");
      for (Body i : bodies) {
        i.draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      t = t + dt;
    }
    StdOut.printf("%d\n", bodies.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < bodies.length; i++) {
      StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                  bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
}
  }

}
