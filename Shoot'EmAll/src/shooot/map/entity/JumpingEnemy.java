package shooot.map.entity;

import shooot.game.Collision;
import shooot.game.GravityCheck;
import shooot.game.Sprite;
import shooot.map.Map;
import shooot.map.Bullet;

/**
 * @author partha
 */
public class JumpingEnemy extends Enemy {

    private int startXpos;
    private boolean facingRight;
    private HitBox[] hitbox;
    private Sprite spriteFacingLeft;
    private Sprite spriteFacingRight;
    private boolean touchesGround;
    private boolean isDead = false;
    private int health = 3;
    private int speed = 0;
    private Bullet shots;
    private int shotCooldown = 120;
    private int score = 0;

    public JumpingEnemy(int posX, int posY, Map m) {
        super(posX, posY, m);
        HitBox[] hitbox = new HitBox[1];

        hitbox[0] = new HitBox(37, 28, 20, 63);



        spriteFacingLeft = new  Sprite(new String[]{"/pics/guy/blue/guy01.png",
                                                    "/pics/guy/blue/guy02.png",
                                                    "/pics/guy/blue/guy03.png",
                                                    "/pics/guy/blue/guy04.png",
                                                    "/pics/guy/blue/guy05.png"},
                                                    true, hitbox);

        spriteFacingRight = new Sprite(new String[]{"/pics/guy/blue/guy01.png",
                                                    "/pics/guy/blue/guy02.png",
                                                    "/pics/guy/blue/guy03.png",
                                                    "/pics/guy/blue/guy04.png",
                                                    "/pics/guy/blue/guy05.png"},
                                                     false, hitbox);
        currentSprite = spriteFacingRight;
        startXpos = posX;
        facingRight = true;

        shots = new Bullet(mapReference);
        score = 0;

    }

    @Override
    public void collided(Collision c) {
        if (c.collidedWith instanceof StaticEntity ||  c.collidedWith instanceof UserEntity) {

           
            double dlx = c.deltaLeft;
            double drx = c.deltaRight;
            double dty = c.deltaTop;
            double dby = c.deltaBottom;

            if (c.crossedLeft && pposX < posX && dty > 20 && dby > 20) {
                facingRight = true;
            }
            if (c.crossedRight && pposX > posX && dty > 8 && dby > 6) {
                facingRight = false;
            }
            if (c.crossedTop && posY > pposY && (drx > 8 && dlx > 8)) {
                newPosY -= dty;
                touchesGround = true;
            }
            if (c.crossedBottom && posY < pposY && (drx > 8 && dlx > 8)) {
                newPosY += dby;
            }
        } else if (c.collidedWith instanceof GunShot && ((GunShot) c.collidedWith).getShooter() != this) {
            health -= 1;
            score += 20;
            if (health == 0) {
                isDead = true;
            } else {
                speed += 1;
            }
        }

    }
    
    @Override
    public void calculateMovement() {
        if (!isDead) {

            if (ticker < 5) {
                ticker++;
            } else {
                ticker = 0;
                currentSprite.nextImage();
            }
            if (!touchesGround) {
                double temp = GravityCheck.calculateGravity(posY, pposY, 16);
                newPosY = posY - temp;
            } else if (touchesGround) {
                newPosY -= (6 + speed);
                touchesGround = false;
            }
            if (!facingRight) {
                currentSprite = spriteFacingLeft;
            } else if (facingRight) {
                currentSprite = spriteFacingRight;
            }
            double[] playerPos = mapReference.getPlayerState();
            int playerPosX = (int) (playerPos[0] - posX);
            if (playerPosX < 0) {
                facingRight = false;
            } else {
                facingRight = true;
            }
            if (shotCooldown > 0) {
                shotCooldown--;
            }
            if (shotCooldown == 0) {
                if (facingRight && playerPosX > 0 && playerPosX < 300
                        || !facingRight && playerPosX < 0 && playerPosX > -300) {
                    addshot();
                    shotCooldown += 120;
                }
            }
            shots.update();
        }
    }
    @Override
    public boolean facingRight() {
        return true;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
    private void addshot() {
        if (facingRight) {
            shots.addShot(posX + 75, posY + 45, facingRight, this, mapReference);
        } else {
            shots.addShot(posX + 15, posY + 45, facingRight, this, mapReference);

        }
    }
    @Override
    public boolean isDead() {
        return isDead;
    }
    @Override
    public int getScore() {
        return score;
    }
}
