package shooot.map;

import shooot.game.SoundPlay;
import shooot.map.entity.Crate;
import shooot.map.entity.UserEntity;
import shooot.map.entity.Enemy;
import shooot.map.entity.JumpingEnemy;
import shooot.map.entity.PatrolingEnemy;

/**
 * @author partha
 */
public class LevelTwo extends Map {
    public LevelTwo() {
        super("");
    }
    @Override
    public void update() {
        super.update();
    }
     @Override
    public void initialiseStatic() {
        super.initialiseStatic();
        populateWorld();
    }
    private void populateWorld() {
 
worldstore.add(new Crate(-400,440,this));
worldstore.add(new Crate(-400,480,this));
worldstore.add(new Crate(-400,520,this));
worldstore.add(new Crate(-400,560,this));
worldstore.add(new Crate(-350,560,this));
worldstore.add(new Crate(-300,560,this));
worldstore.add(new Crate(-250,560,this));
worldstore.add(new Crate(-200,560,this));
worldstore.add(new Crate(-150,560,this));
worldstore.add(new Crate(-100,560,this));
worldstore.add(new Crate(-50,560,this));
worldstore.add(new Crate(0,560,this));
worldstore.add(new Crate(50,560,this));
worldstore.add(new Crate(100,560,this));
worldstore.add(new Crate(150,560,this));
worldstore.add(new Crate(200,560,this));
worldstore.add(new Crate(250,560,this));
worldstore.add(new Crate(300,560,this));
worldstore.add(new Crate(350,560,this));
worldstore.add(new Crate(400,560,this));
worldstore.add(new Crate(450,560,this));
worldstore.add(new Crate(500,560,this));
worldstore.add(new Crate(500,520,this));
worldstore.add(new Crate(500,480,this));
worldstore.add(new Crate(500,440,this));
worldstore.add(new Crate(600,320,this));
worldstore.add(new Crate(650,320,this));
worldstore.add(new Crate(800,440,this));
worldstore.add(new Crate(850,440,this));
worldstore.add(new Crate(1000,320,this));
worldstore.add(new Crate(1050,320,this));
worldstore.add(new Crate(1100,320,this));
worldstore.add(new Crate(1250,320,this));
worldstore.add(new Crate(1250,360,this));
worldstore.add(new Crate(1250,400,this));
worldstore.add(new Crate(1250,440,this));
worldstore.add(new Crate(1250,480,this));
worldstore.add(new Crate(1250,520,this));
worldstore.add(new Crate(1250,560,this));
worldstore.add(new Crate(1250,280,this));
worldstore.add(new Crate(1250,240,this));
worldstore.add(new Crate(1250,200,this));
worldstore.add(new Crate(1600,320,this));
worldstore.add(new Crate(1650,320,this));
worldstore.add(new Crate(1700,320,this));
worldstore.add(new Crate(1750,320,this));
worldstore.add(new Crate(1800,320,this));
worldstore.add(new Crate(1850,320,this));
worldstore.add(new Crate(1900,320,this));
worldstore.add(new Crate(1950,320,this));
worldstore.add(new Crate(2000,320,this));
worldstore.add(new Crate(2000,280,this));
worldstore.add(new Crate(2000,240,this));
worldstore.add(new Crate(1600,280,this));
worldstore.add(new Crate(1600,240,this));
worldstore.add(new Crate(1400,400,this));
worldstore.add(new Crate(1450,400,this));
worldstore.add(new Crate(1650,520,this));
worldstore.add(new Crate(1750,520,this));
worldstore.add(new Crate(1700,520,this));
worldstore.add(new Crate(1800,520,this));
worldstore.add(new Crate(1850,520,this));
worldstore.add(new Crate(750,40,this));
worldstore.add(new Crate(800,40,this));
worldstore.add(new Crate(900,40,this));
worldstore.add(new Crate(2200,280,this));
worldstore.add(new Crate(2250,280,this));
worldstore.add(new Crate(2300,280,this));
worldstore.add(new Crate(2350,280,this));
worldstore.add(new Crate(2450,480,this));
worldstore.add(new Crate(2500,440,this));
worldstore.add(new Crate(2550,400,this));
worldstore.add(new Crate(2600,360,this));
worldstore.add(new Crate(2650,320,this));
worldstore.add(new Crate(2700,280,this));
worldstore.add(new Crate(2600,240,this));
worldstore.add(new Crate(2650,240,this));
worldstore.add(new Crate(2700,240,this));
worldstore.add(new Crate(2750,240,this));
worldstore.add(new Crate(2800,240,this));
worldstore.add(new Crate(2850,240,this));
worldstore.add(new Crate(2950,240,this));
worldstore.add(new Crate(2900,240,this));
worldstore.add(new Crate(2600,200,this));
worldstore.add(new Crate(2950,200,this));
worldstore.add(new Crate(2750,320,this));
worldstore.add(new Crate(2800,320,this));
worldstore.add(new Crate(2800,360,this));
worldstore.add(new Crate(2850,400,this));
worldstore.add(new Crate(2900,400,this));
worldstore.add(new Crate(2900,440,this));
worldstore.add(new Crate(2950,440,this));
worldstore.add(new Crate(2950,480,this));
worldstore.add(new Crate(2950,560,this));
worldstore.add(new Crate(2750,560,this));
worldstore.add(new Crate(2450,560,this));
worldstore.add(new Crate(2150,560,this));
worldstore.add(new Crate(2200,160,this));
worldstore.add(new Crate(2250,120,this));
worldstore.add(new Crate(2300,120,this));
worldstore.add(new Crate(2400,160,this));
worldstore.add(new Crate(2350,160,this));
worldstore.add(new Crate(2400,200,this));
worldstore.add(new Crate(2450,240,this));
worldstore.add(new Crate(2500,240,this));
worldstore.add(new Crate(3350,480,this));
worldstore.add(new Crate(3350,520,this));
worldstore.add(new Crate(3350,560,this));
worldstore.add(new Crate(3500,560,this));
worldstore.add(new Crate(3400,520,this));
worldstore.add(new Crate(3450,520,this));
worldstore.add(new Crate(3500,520,this));
worldstore.add(new Crate(3550,520,this));
worldstore.add(new Crate(3600,520,this));
worldstore.add(new Crate(3650,520,this));
worldstore.add(new Crate(3700,520,this));
worldstore.add(new Crate(3750,520,this));
worldstore.add(new Crate(3750,480,this));
worldstore.add(new Crate(3800,440,this));
worldstore.add(new Crate(3850,400,this));
worldstore.add(new Crate(3900,360,this));
worldstore.add(new Crate(3950,360,this));
worldstore.add(new Crate(4200,360,this));
worldstore.add(new Crate(4300,360,this));
worldstore.add(new Crate(4500,360,this));
worldstore.add(new Crate(4600,360,this));
worldstore.add(new Crate(4700,360,this));
worldstore.add(new Crate(4500,400,this));
worldstore.add(new Crate(4500,440,this));
worldstore.add(new Crate(4500,480,this));
worldstore.add(new Crate(4600,400,this));
worldstore.add(new Crate(4600,440,this));
worldstore.add(new Crate(4600,480,this));
worldstore.add(new Crate(4700,400,this));
worldstore.add(new Crate(4700,440,this));
worldstore.add(new Crate(4700,480,this));
worldstore.add(new Crate(5100,560,this));
worldstore.add(new Crate(5100,520,this));
worldstore.add(new Crate(5100,480,this));
worldstore.add(new Crate(5100,400,this));
worldstore.add(new Crate(5100,440,this));
worldstore.add(new Crate(5050,360,this));
worldstore.add(new Crate(5100,360,this));
worldstore.add(new Crate(5150,360,this));
worldstore.add(new Crate(5450,480,this));
worldstore.add(new Crate(5500,440,this));
worldstore.add(new Crate(5550,400,this));
worldstore.add(new Crate(5600,400,this));
worldstore.add(new Crate(5650,360,this));
worldstore.add(new Crate(5600,320,this));
worldstore.add(new Crate(5700,520,this));
worldstore.add(new Crate(5750,520,this));
worldstore.add(new Crate(5800,520,this));
worldstore.add(new Crate(5850,520,this));
worldstore.add(new Crate(5900,520,this));
worldstore.add(new Crate(5950,520,this));
worldstore.add(new Crate(6000,520,this));
worldstore.add(new Crate(6050,520,this));
worldstore.add(new Crate(6100,520,this));
worldstore.add(new Crate(6150,520,this));
worldstore.add(new Crate(5700,480,this));
worldstore.add(new Crate(5700,440,this));
worldstore.add(new Crate(5700,400,this));
worldstore.add(new Crate(6200,480,this));
worldstore.add(new Crate(6250,440,this));
worldstore.add(new Crate(6250,400,this));
worldstore.add(new Crate(6300,360,this));
worldstore.add(new Crate(6350,320,this));
worldstore.add(new Crate(6400,280,this));
worldstore.add(new Crate(5400,120,this));
worldstore.add(new Crate(5450,120,this));
worldstore.add(new Crate(5500,120,this));
worldstore.add(new Crate(5350,240,this));
worldstore.add(new Crate(5400,240,this));
worldstore.add(new Crate(6550,520,this));
worldstore.add(new Crate(6600,520,this));
worldstore.add(new Crate(6650,520,this));
worldstore.add(new Crate(6700,520,this));
worldstore.add(new Crate(6700,560,this));
worldstore.add(new Crate(6650,560,this));
worldstore.add(new Crate(6600,560,this));
worldstore.add(new Crate(6550,560,this));
worldstore.add(new Crate(6700,480,this));
worldstore.add(new Crate(6500,480,this));
worldstore.add(new Crate(7100,560,this));
worldstore.add(new Crate(7150,560,this));
worldstore.add(new Crate(7250,560,this));
worldstore.add(new Crate(7200,560,this));
worldstore.add(new Crate(7100,400,this));
worldstore.add(new Crate(7100,360,this));
worldstore.add(new Crate(7150,360,this));
worldstore.add(new Crate(7200,360,this));
worldstore.add(new Crate(7250,360,this));
worldstore.add(new Crate(7100,320,this));
worldstore.add(new Crate(7300,360,this));
worldstore.add(new Crate(7300,320,this));
worldstore.add(new Crate(7600,440,this));
worldstore.add(new Crate(7650,440,this));
worldstore.add(new Crate(7700,440,this));
worldstore.add(new Crate(7850,320,this));
worldstore.add(new Crate(7900,320,this));
worldstore.add(new Crate(7950,320,this));
worldstore.add(new Crate(8000,320,this));
worldstore.add(new Crate(8250,200,this));
worldstore.add(new Crate(8300,200,this));
worldstore.add(new Crate(8350,200,this));
worldstore.add(new Crate(8400,200,this));
worldstore.add(new Crate(8450,200,this));
worldstore.add(new Crate(8700,320,this));
worldstore.add(new Crate(8750,320,this));
worldstore.add(new Crate(8850,320,this));
worldstore.add(new Crate(8800,320,this));
worldstore.add(new Crate(8950,320,this));
worldstore.add(new Crate(9000,320,this));
worldstore.add(new Crate(9300,240,this));
worldstore.add(new Crate(9300,280,this));
worldstore.add(new Crate(9300,320,this));
worldstore.add(new Crate(9300,360,this));
worldstore.add(new Crate(9300,400,this));
worldstore.add(new Crate(9300,440,this));
worldstore.add(new Crate(9300,480,this));
worldstore.add(new Crate(9350,480,this));
worldstore.add(new Crate(9400,480,this));
worldstore.add(new Crate(9450,480,this));
worldstore.add(new Crate(9500,480,this));
worldstore.add(new Crate(9550,480,this));
worldstore.add(new Crate(9600,480,this));
worldstore.add(new Crate(9650,480,this));
worldstore.add(new Crate(9650,440,this));
worldstore.add(new Crate(9650,400,this));
worldstore.add(new Crate(9650,360,this));
worldstore.add(new Crate(9700,360,this));
worldstore.add(new Crate(9900,360,this));
worldstore.add(new Crate(9900,400,this));
worldstore.add(new Crate(9900,440,this));
worldstore.add(new Crate(10050,440,this));
worldstore.add(new Crate(10150,440,this));
worldstore.add(new Crate(10200,440,this));
worldstore.add(new Crate(10300,0,this));
worldstore.add(new Crate(10300,80,this));
worldstore.add(new Crate(10300,40,this));
worldstore.add(new Crate(10300,120,this));
worldstore.add(new Crate(10300,160,this));
worldstore.add(new Crate(10300,200,this));
worldstore.add(new Crate(10300,280,this));
worldstore.add(new Crate(10300,240,this));
worldstore.add(new Crate(10300,320,this));
worldstore.add(new Crate(10300,360,this));
worldstore.add(new Crate(10300,400,this));
worldstore.add(new Crate(10300,440,this));
worldstore.add(new Crate(10300,480,this));
worldstore.add(new Crate(10300,520,this));
    }

    @Override
    public void initialiseNonStatic(String s) {
        super.initialiseNonStatic(s);
        
        bg = new Background("/pics/back1.png", 1.25);

        UserEntity test = new UserEntity(-300, 350, "", this, true);
        playerEntity = test;

        populateWorld();
        
        enemy = new PatrolingEnemy(-300, 100, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(-200, 80, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(1900, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(2750, 80, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(3500, 280, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(3600, 280, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(5000, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(5080, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(6030, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(6100, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(3450, 280, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(6450, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(6550, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(6600, 320, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(7150, 360, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(7200, 360, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(7250, 360, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(8100, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(8550, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(8850, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(9100, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(10150, 160, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(10150, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(10000, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new JumpingEnemy(9750, 240, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(9650, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        enemy = new PatrolingEnemy(6350, 200, this);
        renderableEntities.add(enemy);
        moveableEntities.add(enemy);
        entities.add(enemy);
        
        renderableEntities.add(test);
        moveableEntities.add(test);
        entities.add(test);

        String filename = "/sound/zabutom.lets.shooting.mp3";
        soundtrack = new SoundPlay(filename);
        if (!mute) {
            soundtrack.play();
        }
    }

   
}
