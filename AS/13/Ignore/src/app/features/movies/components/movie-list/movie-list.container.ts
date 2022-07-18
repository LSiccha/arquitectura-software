import {Component} from "@angular/core";
import {merge, Observable, Subject} from "rxjs";
import {Movie} from "../../../../core/models/movie.model";
import {MovieService} from "../../../../core/services/movie.service";




@Component(
  {
    selector: 'movie-list',
    templateUrl: 'movie-list.component.html'
  }
)

export class MovieListContainerComponent{
  private movieAdd: Subject<Movie> = new Subject<Movie>();
  private movieRemove: Subject<Movie> = new Subject<Movie>();

  constructor(private movieService: MovieService) {}


}
