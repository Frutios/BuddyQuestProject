
import {User} from "../components/users/user";
import {Sport} from "./sport";
import {Localisation} from "./localisation";

export class Event{
  //constructor(
    private _title: string | undefined;
    private _urlImage:string| undefined;
    private _nbPartnerMax:string| undefined;
    private _sport: Sport| undefined;
    private _dateEventCreate:string| undefined;
    private _startTime:string| undefined;
    private _endTime:string| undefined;
    private _place:string| undefined;
    private _flatGender:boolean| undefined;
    private _ageMax:string| undefined;
    private _ageMin:string| undefined;
    private _user: User| undefined;
    private _description:string| undefined;
    private _state: number| undefined;
    private _localisation:Localisation| undefined;
  //){}


  get title(): string | undefined {
    return this._title;
  }

  set title(value: string | undefined) {
    this._title = value;
  }

  get urlImage(): string | undefined {
    return this._urlImage;
  }

  set urlImage(value: string | undefined) {
    this._urlImage = value;
  }

  get nbPartnerMax(): string | undefined {
    return this._nbPartnerMax;
  }

  set nbPartnerMax(value: string | undefined) {
    this._nbPartnerMax = value;
  }

  get sport(): Sport | undefined {
    return this._sport;
  }

  set sport(value: Sport | undefined) {
    this._sport = value;
  }

  get dateEventCreate(): string | undefined {
    return this._dateEventCreate;
  }

  set dateEventCreate(value: string | undefined) {
    this._dateEventCreate = value;
  }

  get startTime(): string | undefined {
    return this._startTime;
  }

  set startTime(value: string | undefined) {
    this._startTime = value;
  }

  get endTime(): string | undefined {
    return this._endTime;
  }

  set endTime(value: string | undefined) {
    this._endTime = value;
  }

  get place(): string | undefined {
    return this._place;
  }

  set place(value: string | undefined) {
    this._place = value;
  }

  get flatGender(): boolean | undefined {
    return this._flatGender;
  }

  set flatGender(value: boolean | undefined) {
    this._flatGender = value;
  }

  get ageMax(): string | undefined {
    return this._ageMax;
  }

  set ageMax(value: string | undefined) {
    this._ageMax = value;
  }

  get ageMin(): string | undefined {
    return this._ageMin;
  }

  set ageMin(value: string | undefined) {
    this._ageMin = value;
  }

  get user(): User | undefined {
    return this._user;
  }

  set user(value: User | undefined) {
    this._user = value;
  }

  get description(): string | undefined {
    return this._description;
  }

  set description(value: string | undefined) {
    this._description = value;
  }

  get state(): number | undefined {
    return this._state;
  }

  set state(value: number | undefined) {
    this._state = value;
  }

  get localisation(): Localisation | undefined {
    return this._localisation;
  }

  set localisation(value: Localisation | undefined) {
    this._localisation = value;
  }

  get infoDateEventCreate(){
    //create if par today
    return this.dateEventCreate ;
}
get infoDateEvent(){
    //15 July 2021        10h00 ->11h30
    /*String dateFormatStart,dateFormatEnd ;
    dateFormatStart =this.startTime.toLocalDate().toString() +" " + this.startTime.toLocalTime().toString() ;
    dateFormatEnd=this.endTime.toLocalDate().toString() +" "+this.endTime.toLocalTime().toString();*/
    return  this.startTime;
}
get infoNroPartner(){
    return this.nbPartnerMax + " Partners";
}
}

