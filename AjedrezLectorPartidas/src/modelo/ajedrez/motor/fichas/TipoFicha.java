package modelo.ajedrez.motor.fichas;

public enum TipoFicha {

	Alfil("B") {
		@Override
		public boolean isRey() {
			return false;
		}

		@Override
		public boolean isTorre() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	Caballo("N") {
		@Override
		public boolean isRey() {
			return false;
		}

		@Override
		public boolean isTorre() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	Peon("E") {
		@Override
		public boolean isRey() {
			return false;
		}

		@Override
		public boolean isTorre() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	Reina("Q") {
		@Override
		public boolean isRey() {
			return false;
		}

		@Override
		public boolean isTorre() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	Rey("K") {
		@Override
		public boolean isRey() {
			return true;
		}

		@Override
		public boolean isTorre() {
			// TODO Auto-generated method stub
			return false;
		}
	},
	Torre("R") {
		@Override
		public boolean isRey() {
			return false;
		}

		@Override
		public boolean isTorre() {
			// TODO Auto-generated method stub
			return true;
		}
	};

	private String nombreFicha;

	TipoFicha(final String nombreFicha) {
		this.nombreFicha = nombreFicha;
	}

	@Override
	public String toString() {
		return this.nombreFicha;
	}

	public abstract boolean isRey();

	public abstract boolean isTorre();

}
