using ProyectoComunidad.Persistance.Manages;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ProyectoComunidad.Persistance;

namespace ProyectoComunidad.Domain
{
    /// <summary>
    /// Represents a community with properties such as name, address, founding date, size, pool availability, and community management.
    /// </summary>
    class Community
    {
        /// <summary>
        /// Gets or sets the name of the community.
        /// </summary>
        public string name { get; set; }

        /// <summary>
        /// Gets or sets the address of the community.
        /// </summary>
        public String address { get; set; }

        /// <summary>
        /// Gets or sets the founding date of the community.
        /// </summary>
        public String foundingDate { get; set; }

        /// <summary>
        /// Gets or sets the size of the community.
        /// </summary>
        public int size { get; set; }

        /// <summary>
        /// Gets or sets a value indicating whether the community has a pool.
        /// </summary>
        public bool havePool { get; set; }

        /// <summary>
        /// Gets or sets the community management.
        /// </summary>
        public CommunityManage cm { get; set; }

        /// <summary>
        /// Initializes a new instance of the <see cref="Community"/> class.
        /// </summary>
        public Community()
        {
            CommunityManage cm = new CommunityManage();
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Community"/> class with a specified name.
        /// </summary>
        public Community(string name)
        {
            this.name = name;
        }

        /// <summary>
        /// Initializes a new instance of the <see cref="Community"/> class with specified properties.
        /// </summary>
        public Community(string name, string address, string foundingDate, int size, bool havePool, CommunityManage cm)
        {
            this.name = name;
            this.address = address;
            this.foundingDate = foundingDate;
            this.size = size;
            this.havePool = havePool;
            this.cm = cm;
        }

        /// <summary>
        /// Loads the community data from the database.
        /// </summary>
        public void reaC()
        {
            cm.loadDataBase();
        }

        /// <summary>
        /// Gets the list of communities.
        /// </summary>
        public List<Community> getListTask()
        {
            return cm.listCommunity;
        }

        /// <summary>
        /// Inserts the community into the database.
        /// </summary>
        public void insert()
        {
            cm.insertCommunity(this);
        }

        /// <summary>
        /// Deletes the community from the database.
        /// </summary>
        public void delete()
        {
            cm.deleteCommunity(this);
        }

        /// <summary>
        /// Updates the community in the database.
        /// </summary>
        public void update()
        {
            cm.updateCommunity(this);
        }
    }
}
