using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tutorial {
	class Program {
		static void Main(string[] args) {
			// print
			Console.WriteLine("Hello World!");

			// variables
			int i = 56;
			string meme = "hello" + " world";

			// function calls
			TestFunction();

			Console.ReadKey();
		}

		static void TestFunction() {

		}

		static bool secondTestFunction(int i) {
			return i > 100;
		}
	}
}
