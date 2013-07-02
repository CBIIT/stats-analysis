/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.webservice;

import org.w3c.dom.*;
import java.util.*;

import gov.nih.nci.system.applicationservice.*;


import org.apache.axis.AxisFault;
import org.apache.axis.MessageContext;
import org.apache.axis.transport.http.HTTPConstants;

import org.apache.log4j.*;


, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
* WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 * <!-- LICENSE_TEXT_END -->
*/

/**
* WebService presents a method to query the System.
* @author caBIO Team 
* @version 1.0 
*/
public class DomainQueryService
{
	private static Logger log = Logger.getLogger(DomainQueryService.class);

	 public List search(String searchClassName, Object criterion) throws Exception
	 {
		try
		{
		 	ApplicationService applicationService = ApplicationServiceProvider.getApplicationService();		 	
		 	List criterionList = applicationService.search(searchClassName, criterion);
			return criterionList;
		}catch(Exception e)
		{
			log.error("Error thrown from Generic Service " + e.getMessage());
			throw new org.apache.axis.AxisFault("Error thrown from Generic Service "+e.getMessage() );
		}
	}

}
