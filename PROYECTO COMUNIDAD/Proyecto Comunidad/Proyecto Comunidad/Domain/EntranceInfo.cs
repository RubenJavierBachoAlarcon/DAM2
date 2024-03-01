using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto_Comunidad.Domain
{
    /// <summary>
    /// Represents information about an entrance in a community with properties such as id, number of stairs, floors, and letters.
    /// </summary>
    internal class EntranceInfo
    {
        /// <summary>
        /// Gets or sets the id of the entrance.
        /// </summary>
        public int id { get; set; }

        /// <summary>
        /// Gets or sets the number of stairs in the entrance.
        /// </summary>
        public int numStairs { get; set; }

        /// <summary>
        /// Gets or sets the number of floors in the entrance.
        /// </summary>
        public int numFloors { get; set; }

        /// <summary>
        /// Gets or sets the number of letters in the entrance.
        /// </summary>
        public int numLetters { get; set; }

        /// <summary>
        /// Initializes a new instance of the <see cref="EntranceInfo"/> class with specified properties.
        /// </summary>
        public EntranceInfo(int id, int numStairs, int numFloors, int numLetters)
        {
            this.id = id;
            this.numStairs = numStairs;
            this.numFloors = numFloors;
            this.numLetters = numLetters;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="EntranceInfo"/> class with specified properties.
        /// </summary>
        public EntranceInfo(int numStairs, int numFloors, int numLetters)
        {
            this.numStairs = numStairs;
            this.numFloors = numFloors;
            this.numLetters = numLetters;
        }
    }
}
