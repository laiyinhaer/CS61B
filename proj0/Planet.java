public class Planet {
    public double xxPos;// Its current x position
    public double yyPos;// Its current y position
    public double xxVel;// Its current velocity in the x direction
    public double yyVel;// Its current velocity in the y direction
    public double mass;// Its mass
    public String imgFileName;// The name of the file that corresponds to the image that depicts the body
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return G * this.mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p){
        double r = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * (p.xxPos - this.xxPos) / r;
    }

    public double calcForceExertedByY(Planet p){
        double r = this.calcDistance(p);
        double force = this.calcForceExertedBy(p);
        return force * (p.yyPos - this.yyPos) / r;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double NetForceX = 0;
        for(int i = 0; i < planets.length; i++){
            if (this.equals(planets[i])){
                continue;
            }
            NetForceX += this.calcForceExertedByX(planets[i]);
        }
        return NetForceX;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double NetForceY = 0;
        for(int i = 0; i < planets.length; i++){
            if (this.equals(planets[i])){
                continue;
            }
            NetForceY += this.calcForceExertedByY(planets[i]);
        }
        return NetForceY;
    }

    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}


