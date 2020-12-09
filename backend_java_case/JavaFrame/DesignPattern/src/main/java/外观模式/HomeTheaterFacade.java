package 外观模式;

/**
 * 构造家庭影院外观
 * 
 * @author Administrator
 * 
 */
public class HomeTheaterFacade {
	// 组合会用到的全部组件
	Amplifier amp;
	Tuner tuner;
	DvdPlayer dvd;
	CdPlayer cd;
	Projector projector;
	TheaterLights lights;
	Screen screen;
	PopcornPopper popper;
	/**
	 * 外观将子系统中每一个组件的引用都传入它的构造器中,然后外观把他们赋给相应的实例变量
	 */
	public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvd,
			CdPlayer cd, Projector projector, TheaterLights lights,
			Screen screen, PopcornPopper popper) {
		    this.amp = amp;
		    this.tuner = tuner;
		    this.dvd = dvd;
		    this.cd = cd;
		    this.projector = projector;
		    this.lights = lights;
		    this.screen = screen;
		    this.popper = popper;
	}
	public void watchMovie(String movie){
		System.out.println("Get ready to watch a movie...");
		amp.on();
		tuner.on();
		dvd.on();
		cd.on();
		projector.on();
		lights.on();
		screen.on();
		popper.on();
	}
	public void endMovie(){
		System.out.println("shutting movie theater down...");
		amp.off();
		tuner.off();
		dvd.off();
		cd.off();
		projector.off();
		lights.off();
		screen.off();
		popper.off();
	}
}
