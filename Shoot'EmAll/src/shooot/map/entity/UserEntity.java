package shooot.map.entity;

import shooot.game.Collision;
import shooot.game.KeyInput;
import shooot.game.GravityCheck;
import shooot.game.Sprite;
import shooot.map.Map;
import shooot.map.Bullet;
import java.awt.Graphics;


public class UserEntity extends MovingEntity {

 
    protected int spriteTicker;

    protected Sprite rightSprite;

    protected Sprite standSpriteRight;

    protected Sprite leftSprite;

    protected Sprite standSpriteLeft;

    protected boolean facingRight = true;

    private boolean touchesGround;
    private String name;
    private double origPosX;
    private double origPosY;
    
    private boolean isDead = false;

    private Bullet shots;
    private int shotTimer;
    private int lastShot;

    private int hp;
    private int score;

    public UserEntity(double posX, double posY, String name, Map map, boolean setSprites) {
        super(posX, posY, map);
        spriteTicker = 0;
        touchesGround = false;
        origPosX = posX;
        origPosY = posY;

        this.name = name;
        
        if (setSprites) {
            HitBox[] hitbox = new HitBox[1];

            hitbox[0] = new HitBox(37, 28, 20, 63);


            rightSprite = new Sprite(new String[]{"/pics/hero/guy01.png.png", 
                                                  "/pics/hero/guy02.png.png", 
                                                  "/pics/hero/guy03.png.png", 
                                                  "/pics/hero/guy04.png.png", 
                                                  "/pics/hero/guy05.png.png"}, false, hitbox);
            standSpriteRight = new Sprite(new String[]{"/pics/hero/guy01.png.png"}, false, hitbox);
            leftSprite = new Sprite(new String[]{"/pics/hero/guy01.png.png", 
                                                 "/pics/hero/guy02.png.png", 
                                                 "/pics/hero/guy03.png.png", 
                                                 "/pics/hero/guy04.png.png", 
                                                 "/pics/hero/guy05.png.png"}, true, hitbox);
            standSpriteLeft = new Sprite(new String[]{"/pics/hero/guy01.png.png"}, true, hitbox);

            currentSprite = standSpriteRight;
        }

        shots = new Bullet(mapReference);
        lastShot = 0;
        shotTimer = 0;
        hp = 100;
        score = 0;
    }

    @Override
    public void calculateMovement() {
        newPosX = posX;
        newPosY = posY;

        shotTimer++;
        if (!isDead) {
            if (KeyInput.get().right() && !KeyInput.get().left()) {
                if (currentSprite != rightSprite) {
                    newPosX += (currentSprite.getOffset());
                    currentSprite.resetImage();
                    currentSprite = rightSprite;
                    rightSprite.resetImage();
                    spriteTicker = 0;
                    facingRight = true;
                }
                newPosX += 4;
            } else if (KeyInput.get().left() && !KeyInput.get().right()) {
                if (currentSprite != leftSprite) {
                    newPosX += (currentSprite.getOffset());
                    currentSprite.resetImage();
                    currentSprite = leftSprite;
                    leftSprite.resetImage();
                    spriteTicker = 0;
                    facingRight = false;
                }
                newPosX -= 4;
            } else {
                if (currentSprite != standSpriteRight && currentSprite != standSpriteLeft) {
                    currentSprite.resetImage();
                    if (currentSprite == rightSprite) {
                        currentSprite = standSpriteRight;
                        standSpriteRight.resetImage();
                        facingRight = true;
                    } else { 
                        currentSprite = standSpriteLeft;
                        standSpriteLeft.resetImage();
                        facingRight = false;
                    }
                    spriteTicker = 0;
                }
            }
            if (KeyInput.get().attack() && shotTimer - lastShot > 30) {
                addShot(0);
            }
            updateShots();
            if (posY >= 598) {
                isDead = true;
            } 
            else if (posY < 600 && !touchesGround) {
                double temp = GravityCheck.calculateGravity(posY, pposY, 16);
                newPosY = posY - temp;
            } else if (KeyInput.get().jump()) {
                
                newPosY -= 7;
            }
            if (spriteTicker < 5) {
                spriteTicker++;
            } else {
                spriteTicker = 0;
                currentSprite.nextImage();
            }

            touchesGround = false;
        }
    }

    public boolean facingRight() {
        return facingRight;
    }

    @Override
    public double getXRenderPosition() {
        return posX - 400 + currentSprite.getWidth() / 2;
    }

    @Override
    public double getYRenderPosition() {
        return 0;
    }

    @Override
    public void renderHitBox(Graphics g, double x, double y) {

        double posX = this.posX - x;
        double posY = this.posY - y;

        g.drawRect((int) posX, (int) posY, this.getWidth(), this.getHeight());

        HitBox[] hitbox = currentSprite.getHitBox();

        for (int i = 0; i < hitbox.length; i++) {
            hitbox[i].draw(g, posX, posY);
        }
    }

    @Override
    public void collided(Collision c) {

        if (c.collidedWith instanceof StaticEntity ||  c.collidedWith instanceof Enemy) {

          
            double dty = c.deltaTop;
            double dby = c.deltaBottom;

            if (c.crossedLeft && pposX < posX && dty > 8 && dby > 6) {
                newPosX = pposX;
                c = c.collidingEntity.collision(this);
            } else if (c.crossedRight && pposX > posX && dty > 8 && dby > 6) {
                newPosX = pposX;
                c = c.collidingEntity.collision(this);
            } else if (c.crossedTop && posY > pposY) {
                newPosY -= dty;
                posY = newPosY;
                touchesGround = true;
            } else if (c.crossedBottom && posY < pposY) {
                newPosY = pposY;
            }
        } else if (c.collidedWith instanceof GunShot && ((GunShot) c.collidedWith).getShooter() != this) {
            hp -= 10;
            if (hp <= 0) {
                isDead = true;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void resetPosition() {
        posX = origPosX;
        newPosX = origPosX;
        pposX = origPosX;

        posY = origPosY;
        newPosY = origPosY;
        pposY = origPosY;

        isDead = false;
        hp = 100;
        score = 0;
    }

    public void resetPosition(double xPos, double yPos) {
        posX = xPos;
        newPosX = xPos;
        pposX = xPos;

        posY = yPos;
        newPosY = yPos;
        pposY = yPos;

        isDead = false;
        hp = 100;
        score = 0;
    }

    public boolean isDead() {
        return isDead;
    }
    public int lastShot() {
        return lastShot;
    }

    protected void addShot(int lastShot) {
        if (facingRight) {
            shots.addShot(posX + 75, posY + 45, facingRight, this, mapReference);
        } else {
            shots.addShot(posX + 15, posY + 45, facingRight, this, mapReference);

        }
        if (lastShot != 0) {
            this.lastShot = lastShot;
        } else {
            this.lastShot = shotTimer;
        }
    }

    protected void updateShots() {
        shots.update();
    }

    public int getHp() {
        return hp;
    }
    public int getScore() {
        return score;
    }

}
