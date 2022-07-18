import { Injectable } from '@angular/core';
import {Movie} from "../models/movie.model";

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private movies: Movie[] = [
    {
      id: '1',
      name: 'Avatar',
      description: 'Is a 2009 American epic science fiction film directed, written, produced, and co-edited by James Cameron.',
      year: 2009,
      stars: 4
    },
    {
      id: '2',
      name: 'Django Unchained',
      description: 'Django Unchained is a 2012 American revisionist Western[5] film written and directed by Quentin Tarantino,',
      year: 2012,
      stars: 5
    },
    {
      id: '3',
      name: 'Titanic',
      description: 'Titanic is a 1997 American epic romance and disaster film directed, written, produced, and co-edited by James Cameron',
      year: 1997,
      stars: 5
    },
    {
      id: '4',
      name: 'The Lord of the Rings: The Two Towers',
      description: 'The Lord of the Rings: The Two Towers is a 2002 epic fantasy adventure film directed by Peter Jackson from a screenplay by Fran Walsh, Philippa Boyens, Stephen Sinclair, and Jackson,',
      year: 2010,
      stars: 4
    },
    {
      id: '5',
      name: 'Avatar',
      description: 'Pulp Fiction is a 1994 American black comedy crime film written and directed by Quentin Tarantino, who conceived it with Roger Avary. Starring John Travolta, Samuel L. Jackson, Bruce Willis, Tim Roth, Ving Rhames, and Uma Thurman.',
      year: 1994,
      stars: 4
    }
  ]

  constructor() { }

  getMovies(): Movie[]{
    return this.movies;
  }

  getById(id: string): Movie | undefined{
    return this.movies.find(movie => movie.id===id);
  }
}
