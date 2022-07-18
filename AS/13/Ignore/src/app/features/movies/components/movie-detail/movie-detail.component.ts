import {Component, Input, OnInit} from '@angular/core';
import {Movie} from "../../../../core/models/movie.model";
import {Route} from "@angular/router";

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  @Input() movie: Movie;
  constructor(route: Route) {

  }

  ngOnInit(): void {
  }

}
