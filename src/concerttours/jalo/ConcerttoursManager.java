package concerttours.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;

import org.apache.log4j.Logger;

import concerttours.constants.ConcerttoursConstants;

@SuppressWarnings("PMD")
public class ConcerttoursManager extends GeneratedConcerttoursManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( ConcerttoursManager.class.getName() );

	public static final ConcerttoursManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (ConcerttoursManager) em.getExtension(ConcerttoursConstants.EXTENSIONNAME);
	}

}
