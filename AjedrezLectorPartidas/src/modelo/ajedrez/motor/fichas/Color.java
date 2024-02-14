package modelo.ajedrez.motor.fichas;



public enum Color {
	BLANCAS {
		@Override
		public int getDireccion() {
			// TODO Auto-generated method stub
			return 1;
		}

		@Override
		public boolean isBlanca() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isNegra() {
			// TODO Auto-generated method stub
			return false;
		}

	
	},
	NEGRAS {
		@Override
		public int getDireccion() {
			// TODO Auto-generated method stub
			return -1;
		}

		@Override
		public boolean isBlanca() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean isNegra() {
			// TODO Auto-generated method stub
			return true;
		}

	
	};

	public abstract int getDireccion();

	public abstract boolean isBlanca();

	public abstract boolean isNegra();
}