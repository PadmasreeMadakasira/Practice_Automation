package Spotify.Oauth2;


import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import PojoClassess.Pojo;
import applicationApi.PlaylistApicalls;
import io.restassured.response.Response;
import static org.hamcrest.MatcherAssert.assertThat;


public class Playlists
{
   public Pojo playlistBuilder(String name,String description,Boolean _public)
	  {
	     		return new Pojo()
	 					.setName(name)
	 					.setDescription(description)
	 					.setPublic(_public);
	     	}
	     		
	     	public void assertPlaylistEqual(Pojo responseplaylist,Pojo requestplaylist)
	     	{
	     		assertThat(responseplaylist.getName(),equalTo(requestplaylist.getName()));
	 			assertThat(responseplaylist.getDescription(),equalTo(requestplaylist.getDescription()));
	 			assertThat(responseplaylist.getPublic(),equalTo(requestplaylist.getPublic()));
	     	}
	     	public void assertStatuscode(int actualstatuscode,int expectedstatuscode)
	     	{
	     		assertThat(actualstatuscode,equalTo(expectedstatuscode));
	     	}
	 	
	 		@Test
	 		public void CreatePlaylist()
	 		{
	 			Pojo requestplaylist=playlistBuilder("New Playlist","New Playlist Description",false);	
	 			Response response=PlaylistApicalls.post(requestplaylist);
	 			assertStatuscode(response.statusCode(),201);
	 			assertPlaylistEqual(response.as(Pojo.class),requestplaylist);		
	 			System.out.print("First Commit Practice");
	 			
	 			
	 			

	}
  
  
}
