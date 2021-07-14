export class Localisation{
constructor(
  private _id:number,
  private _country:string,
  private _city:string,
  private _longitude:number,
  private _latitude:number,  
){}



  get id(): number  {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get country(): string {
    return this._country;
  }

  set country(value: string) {
    this._country = value;
  }

  get city(): string {
    return this._city;
  }

  set city(value: string) {
    this._city = value;
  }


  get longitude(): number {
    return this._longitude;
  }

  set longitude(value: number) {
    this._longitude = value;
  }

  get latitude(): number {
    return this._latitude;
  }

  set latitude(value: number) {
    this._latitude = value;
  }
}
