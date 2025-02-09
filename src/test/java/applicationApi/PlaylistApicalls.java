package applicationApi;

import PojoClassess.Pojo;
import Utils.ConfigLoader;
import api.RestResource;
import api.Route;
import api.TokenManager;
import io.restassured.response.Response;

public class PlaylistApicalls 
{

	public static Response post(Pojo requestplaylist)
	{
		return RestResource.post(Route.USERS+"/"+ ConfigLoader.getInstance().getUser_id()+ Route.PLAYLISTS,TokenManager.getToken(),requestplaylist);
	}
		
			
}


